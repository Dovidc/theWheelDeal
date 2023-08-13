<template>
  <div class="current-services-form-container">
      <h1>Current Services</h1>
      <div class="vehicle-selection-and-add-new-button"> Vehicle:
          <span>
              <select name="saved-vehicles" id="vehicle-selection">
                  <option value="none">Select Vehicle</option>
                  <!-- below option should show saved users saved vehicles -->
                  <option value=""></option> 
              </select>
          </span>
          <!-- spacing between select and button (should prob just use css like padding lol) -->
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <span>
              <!-- When Clicked "Add New", it should send you to the Registered Vehicles tab -->
             <button v-on:click="showSection('vehicles')">Add New</button>
          </span>
      </div>
      <div>

      </div>

  </div>
</template>

<script>
export default {
   
}

</script>

<style>

</style>