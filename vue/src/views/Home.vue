<template>
  <div class="home">
    <Header />
    <home-tab />
    <services-list />
    <about-us />
    <contact-us />
  </div>
</template>

<script>
import Header from '../components/Header';
import HomeTab from '../components/HomeTab';
import ServicesList from '../components/ServicesList';
import AboutUs from '../components/AboutUs';
import ContactUs from '../components/ContactUs';

export default {
  components: {
    Header,
    HomeTab,
    ServicesList,
    AboutUs,
    ContactUs
  }

};
</script>

<style >

  .header-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #1b1b1bc7;
    color: #fff;
    padding: 1rem;
  }
  nav ul {
    list-style: none;
    margin: 0;
    padding: 0;
  }
  nav ul li {
    display: inline;
    margin-left: 1rem;
  }
  nav ul li a {
    color: #fff;
    text-decoration: none;
  }
  main {
    padding: 2rem;
  }
  .hero-container {
    text-align: center;
    background-color: #010C6E;
    padding: 3rem;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(226, 0, 0, 0.2);
  }
  .hero-container h2 {
    font-size: 2rem;
    margin-bottom: 1rem;
  }
  .cta-button {
    display: inline-block;
    background-color: #FF0000;
    color: rgb(252, 252, 252);
    text-decoration: none;
    padding: 1rem 2rem;
    border-radius: 5px;
    transition: background-color 1.0s ease;
  }
  .cta-button:hover {
    background-color: #81FF47;
  }
  .services-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 1rem;
  }
  .services-container .service-item {
    background-color: #76CE12;
    color: #fff;
    padding: 2rem;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
  }
  .services-container .service-item h3 {
    font-size: 1.5rem;
    margin-bottom: 1rem;
  }
  .about-container {
    text-align: center;
    background-color: #093E80;
    color: #fff;
    padding: 3rem;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
  }
  .about-container h2 {
    font-size: 2rem;
    margin-bottom: 1rem;
  }
  .contact-container {
    padding-top: 20px;
    padding-bottom: 20px;
    text-align: center;
    background-color: #FF5E57;
    color: #fff;
    padding: 3rem;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
  }
  .contact-container h2 {
    font-size: 2rem;
    margin-bottom: 1rem;
  }
  form input,
  form textarea,
  form button {
    width: 100%;
    padding: 1rem;
    border: none;
    border-radius: 5px;
    margin-bottom: 1rem;
  }
  form button {
    background-color: #56FF47;
    color: rgb(0, 0, 0);
    cursor: pointer;
    transition: background-color  ease;
  }
  form button:hover {
    background-color: #2EFF74;
  }
  /* ... Your existing CSS styles ... */
  .service-list {
    list-style: none;
    padding: 0;
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
    gap: 2rem;
  }
  .service-list li {
    background-color: #9C9481;
    color: #fff;
    padding: 2rem;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
  }
  .service-list li img {
    max-width: 100%;
    border-radius: 5px;
    margin-bottom: 1rem;
  }
  .service-list li h3 {
    font-size: 1.5rem;
    margin-bottom: 1rem;
  }
  /* Center the submit button */
.services-container form {
    text-align: center;
  }
  .services-container button {
    display: inline-block;
    margin-top: 1rem;
  }

</style>