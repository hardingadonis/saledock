
// Object 'Validator'

function Validator(options) {

  function getParent(element, selector) {
    while (element.parentElement) {
      if (element.parentElement.matches(selector)) {
        return element.parentElement;
      }
      element = element.parentElement;
    }
  }

  var selectorRules = {};

  // Hàm thực hiện validate
  function validate(inputElement, rule) {
    var errorElement = getParent(inputElement, options.formGroupSelector)
                           .querySelector(options.errorSelector);
    var errorMessage;

    // Lấy ra các rule của selector
    var rules = selectorRules[rule.selector];

    // Lặp qua từng rule và kiểm tra
    // Nếu có lỗi thì dừng việc kiểm tra
    for (var i = 0; i < rules.length; ++i) {
      switch (inputElement.type) {
      case 'checkbox':
        errorMessage =
            rules[i](formElement.querySelector(rule.selector + ':checked'));
        break;
      default:
        errorMessage = rules[i](inputElement.value);
      }

      if (errorMessage)
        break;
    }

    if (errorMessage) {
      errorElement.innerText = errorMessage;
      getParent(inputElement, options.formGroupSelector)
          .classList.add('invalid');
    } else {
      errorElement.innerText = '';
      getParent(inputElement, options.formGroupSelector)
          .classList.remove('invalid');
    }

    return !errorMessage;
  }

  // Lấy element của form cần validate
  var formElement = document.querySelector(options.form);

  if (formElement) {

    // Khi submit form
    formElement.onsubmit = function(e) {
      e.preventDefault();

      // Cập nhật CKEditor trước khi kiểm tra
      updateCKEditor();

      var isFormValid = true;

      // Lặp qua từng rule và validate
      options.rules.forEach(function(rule) {
        var inputElement = formElement.querySelector(rule.selector);
        var isValid = validate(inputElement, rule);
        if (!isValid) {
          isFormValid = false;
        }
      });

      if (isFormValid) {
        formElement.submit();
      }
    };

    // Lặp qua mỗi rule và xử lý (lắng nghe sự kiện blur, input,...)
    options.rules.forEach(function(rule) {
      // Lưu lại các rule cho mỗi input
      if (Array.isArray(selectorRules[rule.selector])) {
        selectorRules[rule.selector].push(rule.test);
      } else {
        selectorRules[rule.selector] = [ rule.test ];
      }

      var inputElements = formElement.querySelectorAll(rule.selector);

      Array.from(inputElements).forEach(function(inputElement) {
        // Xử lí trường hợp blur khỏi input
        inputElement.onblur = function() { validate(inputElement, rule); };

        // Xử lí trường hợp người dùng nhập vào input
        inputElement.oninput = function() {
          var errorElement = getParent(inputElement, options.formGroupSelector)
                                 .querySelector(options.errorSelector);
          errorElement.innerText = '';
          getParent(inputElement, options.formGroupSelector)
              .classList.remove('invalid');
        };
      });
    });
  }
}

// Rules definition

Validator.isRequired = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      // For checkboxes, check if at least one checkbox is checked
      var inputElement = document.querySelector(selector);

      if (inputElement.type === 'checkbox') {
        return inputElement.checked ? undefined
                                    : message || 'Please check this checkbox!';
      }

      // Trim the input value to remove leading and trailing spaces
      var trimmedValue = value.trim();

      // Check if the trimmed value is not empty
      return trimmedValue.length > 0 ? undefined
                                     : message || 'Please enter this field!';
    }
  };
};

Validator.isName = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      var regex = /^\s*([A-Za-z]{1,}([\.,] |[-']| )?)+[A-Za-z]+\.?\s*$/;
      return regex.test(value) ? undefined
                               : message || 'This field must be name!';
    }
  };
};

Validator.isNameProduct = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      var regex = /^[A-Za-z0-9\s]+$/;
      return regex.test(value) ? undefined
                               : message || 'This field must be product name!';
    }
  };
};

Validator.isEmail = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      return regex.test(value) ? undefined
                               : message || 'This field must be email!';
    }
  };
};

Validator.isNumber = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      var regex = /^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g;
      return regex.test(value) ? undefined
                               : message || 'This field must be number!';
    }
  };
};

Validator.minLength = function(selector, min, message) {
  return {
    selector : selector,
    test : function(value) {
      return value.length >= min
                 ? undefined
                 : message || `Please enter a minimum of ${min} characters!`;
    }
  };
};

Validator.isValidLength = function(selector, validLenght, message) {
  return {
    selector : selector,
    test : function(value) {
      return value.length === validLenght
                 ? undefined
                 : message || `Please enter exactly ${validLenght} characters!`;
    }
  };
};

Validator.isConfirmed = function(selector, getConfirmValue, message) {
  return {
    selector : selector,
    test : function(value) {
      return value === getConfirmValue()
                 ? undefined
                 : message || 'The value entered is incorrect!';
    }
  };
};

Validator.isPositive = function(selector, message) {
  return {
    selector : selector,
    test : function(value) {
      // Check if the value is greater than zero
      return (parseFloat(value) > 0)
                 ? undefined
                 : message || 'Please enter a positive value!';
    }
  };
};

Validator.isRequiredDescription = function(selector, message) {
  return {
    selector : selector,
    test : function() {
      // Lấy nội dung văn bản từ CKEditor
      var cleanDescription = getCleanTextFromEditor('description');
      return cleanDescription !== ""
                 ? undefined
                 : message || 'Please enter product description!';
    }
  };
};

// Hàm để lấy nội dung text từ CKEditor
function getCleanTextFromEditor(editorId) {
  var editor = CKEDITOR.instances[editorId];
  var content = editor.getData();
  var doc = new DOMParser().parseFromString(content, 'text/html');
  var cleanText = doc.body.textContent || "";
  cleanText = cleanText.trim();
  return cleanText;
}

// Hàm để cập nhật CKEditor (hoặc kiểm tra xem CKEditor có sẵn không)
function updateCKEditor() {
  if (typeof CKEDITOR !== 'undefined' && CKEDITOR.instances['description']) {
    CKEDITOR.instances['description'].updateElement();
  }
}
