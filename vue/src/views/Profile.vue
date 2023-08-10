<template>
<div id="profile">
  <Header />
  <edit-account />
</div>
  
</template>


<script>

import EditAccount from '../components/EditAccount'
import Header from '../components/Header'
export default {
    components: {
        Header,
        EditAccount
    },
};
</script>

<style>

</style>