<template>
  <div class="header-container">
      <h1><a href="/" class="header-title"> The Wheel Deal</a></h1>
      <nav>
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/#services">Services</a></li>
          <li><a href="/#about">About Us</a></li>
          <li><a href="/#contact">Contact</a></li>
          <li><router-link  :to="{ name: 'login' }">Log in</router-link></li>
          <!-- How to use this for the login button: v-show="$store.state.token === ''" -->
        </ul>
      </nav>
    </div>
</template>

<script>
export default {

}
</script>

<style>

.header-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #1b1b1bc7;
    color: #fff;
    padding: 1rem;
    
  }
  .header-title {
      color: white;
    
      text-decoration: unset;
  }
</style>