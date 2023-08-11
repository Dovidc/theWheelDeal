<template>
<div id="profile">
  <Header />
  <profile-buttons />
</div>
  
</template>


<script>

import ProfileButtons from '../components/ProfileButtons'
import Header from '../components/Header'
export default {
    components: {
        Header,
        ProfileButtons
    },
};
</script>

<style>

</style>