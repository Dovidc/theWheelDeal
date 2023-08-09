<template>
  <div class="header-container">
      <h1>The Wheel Deal</h1>
      <nav>
        <ul>
          <li><a href="#home">Home</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#about">About Us</a></li>
          <li><a href="#contact">Contact</a></li>
          <li><router-link  :to="{ name: 'login' }"><a href="">Log in</a></router-link></li>
          <!-- How to use this for the login button: v-show="store.state.token === ''" -->
        </ul>
      </nav>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>