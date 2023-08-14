<template>
   <div class="appointment-form">
      <Header />
      <div class= "form-container">
    <h1>Create Appointment</h1>
    
    <form @submit.prevent="createAppointment">
      <div class="form-group-vehicle">
        <label for="vehicle">Select Vehicle:</label>
        <select v-model="selectedVehicle" id="vehicle">
          <option value="">Select a vehicle</option>
          <option v-for="vehicle in savedVehicles" :key="vehicle.id" :value="vehicle.id">{{ vehicle.make }} {{ vehicle.model }} ({{ vehicle.year }})</option>
        </select>
      </div>
      <!-- Add New Vehicle Drop Down -->
      <button @click="toggleAddNewVehicle">Add New Vehicle</button>

    <div v-if="showAddNewVehicle" class="add-new-vehicle-form">
      <form>
        <div class="form-group">
          <label for="make">Make:</label>
          <select v-model="newVehicle.make" id="make">
            <option v-for="make in availableMakes" :key="make">{{ make }}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="model">Model:</label>
          <select v-model="newVehicle.model" id="model">
            <option v-for="model in availableModels" :key="model">{{ model }}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="year">Year:</label>
          <input type="number" v-model="newVehicle.year" id="year">
        </div>
        <div class="form-group">
          <label for="color">Color:</label>
          <input type="text" v-model="newVehicle.color" id="color">
        </div>
        <div class="form-group">
          <label for="plateNumber">Plate Number:</label>
          <input type="text" v-model="newVehicle.plateNumber" id="plateNumber">
        </div>
        <div class="form-group">
          <label for="mileage">Mileage:</label>
          <input type="number" v-model="newVehicle.mileage" id="mileage">
        </div>
        <button @click="addNewVehicle">Add Vehicle</button>
      </form>
    </div>
    <!-- Drop Down End -->
      <div class="form-group">
        <label for="appointmentDate">Appointment Date:</label>
        <input type="date" v-model="appointmentDate" id="appointmentDate" >
      </div>
      <div class="form-group">
        <label for="appointmentTime">Vehicle Drop Off Time:</label>
        <input type="time" v-model="appointmentTime" id="appointmentTime" >
      </div>
      <button type="submit">Book Appointment</button>
    </form>
    </div>
  </div>
</template>

<script>
import Header from '../components/Header';
export default {
    components: {
        Header
    },
    data() {
    return {
      selectedVehicle: "",
      savedVehicles: [
        { id: 1, make: "Toyota", model: "Camry", year: 2022 },
        { id: 2, make: "Honda", model: "Civic", year: 2020 },
        // ...other saved vehicles...
      ],
       availableMakes: ['Make1', 'Make2', 'Make3'], // Your available makes from API
      availableModels: ['Model1', 'Model2', 'Model3'], // Your available models from API
      showAddNewVehicle: false,
      newVehicle: {
        make: '',
        model: '',
        year: null,
        color: '',
        plateNumber: '',
        mileage: null
      },
      appointmentDate: "",
      appointmentTime: ""
    };
  },
  methods: {
    createAppointment() {
    //   const appointmentDetails = 
    //     vehicleId: this.selectedVehicle,
    //     date: this.appointmentDate,
    //     time: this.appointmentTime
      
      // You can perform further actions with the appointment details, like sending to a server or updating a database.
    },
     toggleAddNewVehicle() {
      this.showAddNewVehicle = !this.showAddNewVehicle;
      this.newVehicle = {
        make: '',
        model: '',
        year: null,
        color: '',
        plateNumber: '',
        mileage: null
      };
    },
    addNewVehicle() {
      // Handle adding new vehicle logic here
      // Push the newVehicle object to your savedVehicles array, etc.
      // Reset the form and hide the form
      this.toggleAddNewVehicle();
    }
}
  };


</script>

<style scoped>
.add-new-vehicle-form {
  margin-top: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
}

.form-container {

  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid rgb(221, 221, 221);
  background-color: #f8f8f8cc;
  
  
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #555555
}

.form-group {
  margin-bottom: 15px;
  width: 95%;
  
}
#vehicle {
    width: 99%;
}

label {
  display: block;
  font-weight: bold;
}

select,
input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
}
</style>