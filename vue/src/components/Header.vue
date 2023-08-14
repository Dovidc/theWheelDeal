<template>
  <div class="header-container">
      <h1><a href="/" class="header-title"> The Wheel Deal</a></h1>
      <nav>
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/#services">Services</a></li>
          <li><a href="/#about">About Us</a></li>
          <li><a href="/#contact">Contact</a></li>
          <li v-if="$store.state.token"><a href="/profile">Profile</a></li>
          <!-- This should only show when the user is not logged in -->
          <li v-else><router-link :to="{ name: 'login' }">Log in</router-link></li>
          <!-- Shows when the user is logged in -->
          <li v-if="$store.state.token" v-on:click="$store.state.token = ''"><a href="/login">Log Out</a></li>
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