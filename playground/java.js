document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const selectedServices = [];
  
    form.addEventListener("submit", function (event) {
      event.preventDefault();
  
      // Get selected checkboxes
      const checkboxes = document.querySelectorAll("input[name='selectedServices']:checked");
      checkboxes.forEach((checkbox) => {
        selectedServices.push(checkbox.value);
      });
  
      // You can now use the 'selectedServices' array as needed
      console.log("Selected services:", selectedServices);
  
      // Reset the form
      form.reset();
      selectedServices.length = 0;
    });
  });
  