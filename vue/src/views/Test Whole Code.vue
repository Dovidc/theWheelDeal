<template>
  <div class="home">
<body>
  <!-- start of Header -->
  <header>
    <div class="header-container">
      <h1>The Wheel Deal</h1>
      <nav>
        <ul>
          <li><a href="#home">Home</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#about">About Us</a></li>
          <li><a href="#contact">Contact</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <!-- end of header -->
  <main>
    <!-- start of homeTab -->
    <section id="home">
      <div class="hero-container">
        <h2>Welcome to The Wheel Deal</h2>
        <p>We provide high-quality car repair services to keep your vehicle running smoothly.</p>
        <a href="#services" class="cta-button">See Our Services</a>
      </div>
    </section>
    <!-- end of HomeTab -->
    
    <!-- start of ServicesList -->
    <section id="services">
      <h2>                 Our Services</h2>
      <div class="services-container">
        <ul class="service-list">
          <li>
            <img src="https://t4.ftcdn.net/jpg/02/08/39/75/360_F_208397514_XGDiBH2uUdGVIdctkt4NMdhKkGlwbjxy.jpg" alt="Oil Change">
            <h3>Oil Change</h3>
            <p>Regular oil changes keep your engine running smoothly and improve performance.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Oil Change">
              Select
            </label>
          </li>
          <li>
            <img src="https://media.istockphoto.com/id/1364951743/photo/checking-the-brake-discs-of-a-modern-car-vehicle-braking-system.jpg?s=612x612&w=0&k=20&c=QL4hik0Rin2dkoCLfQPLkwDfhiRTCD7gkHS7hTPtBdQ=" alt="Brake Repair">
            <h3>Brake Repair</h3>
            <p>We offer expert brake repair services to ensure your safety on the road.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Brake Repair">
              Select
            </label>
          </li>
          <li>
            <img src="https://st2.depositphotos.com/1003098/8898/i/450/depositphotos_88985818-stock-photo-mechanic-fixing-car-tire-at.jpg" alt="Tire Replacement">
            <h3>Tire Replacement</h3>
            <p>Get new tires installed to improve your car's handling and safety.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://media.istockphoto.com/id/1347150429/photo/professional-mechanic-working-on-the-engine-of-the-car-in-the-garage.jpg?s=612x612&w=0&k=20&c=5zlDGgLNNaWsp_jq_L1AsGT85wrzpdl3kVH-75S-zTU=" alt="Tire Replacement">
            <h3>Engine Check</h3>
            <p> The check engine light had be intimidating, our experts are well skilled.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://www.ocalaautorepair.com/Files/EmailCampaigns/AdobeStock_489011984.jpeg" alt="Tire Replacement">
            <h3>Timing Belt & Chains</h3>
            <p> To ensure performance at 6000rpm something something something.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://perrysburgautoservice.com/wp-content/uploads/2018/12/side-_0001_AdobeStock_84304541.jpg" alt="Tire Replacement">
            <h3>Electrical System Calibration</h3>
            <p> With miles of wire comes miles of wear, frequent checks are paramount .</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://media.istockphoto.com/id/1409882326/photo/pouring-antifreeze-filling-a-windshield-washer-tank-with-an-antifreeze-in-winter-cold-weather.jpg?s=612x612&w=0&k=20&c=9zLe0tB7_qmSLuWL9rc8z8dGnjyLPr_MicC-N_77AlY=" alt="Tire Replacement">
            <h3>Cooling System Service</h3>
            <p> As the planet warms up, cool down your highly effecient internals with our cool joose.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://blog.way.com/wp-content/uploads/2022/11/headlight-bulbs-at-AutoZone.jpg" alt="Tire Replacement">
            <h3>Headlight Replacement</h3>
            <p> Replace your aging incandescent bulbs with enviroment friendly LEDs.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://towingless.com/wp-content/uploads/2022/02/Off-Road-Shocks.jpg" alt="Tire Replacement">
            <h3>Coil Spring Suspension</h3>
            <p>Equip your vehicle with only the most reactive coffee cup stabilising suspension.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <li>
            <img src="https://media.istockphoto.com/id/1404906074/photo/a-man-removes-a-battery-from-under-the-hood-of-a-car-battery-replacement-and-repair.jpg?s=612x612&w=0&k=20&c=qspk7crDpBcXn8Jdi60E42rnsfAj5iG00LP1xfOG6nU=" alt="Tire Replacement">
            <h3>Batteries, Alternator, & Starter Repair </h3>
            <p>Dont let the EV's take the stage, install our child-labor-free electrical equipment today.</p>
            <label>
              <input type="checkbox" name="selectedServices" value="Tire Replacement">
              Select
            </label>
          </li>
          <!-- ... Existing code ... -->
    <section id="services">
      
        <div class="services-container">
          <form action="submit_services.php" method="post"> <!-- Change 'submit_services.php' to your server-side script -->
            <ul class="service-list">
              <!-- ... Existing service items ... -->
            </ul>
            <div class="other-services">
              <!-- ... Other service options ... -->
            </div>
            <button type="submit" class="cta-button">Submit</button> <!-- Added submit button -->
          </form>
        </div>
      </section>
          <!-- Add more service items as needed -->
        </ul>
      </div>
    </section>
    <!-- end of ServicesList -->

    <!-- start of AboutUs -->
    <section id="about">
      <div class="about-container">
        <h2>About Us</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
          magna aliqua.</p>
      </div>
    </section>
    <!-- end of AboutUs -->

    <!-- start of ContactUs -->
    <section id="contact">
      <div class="contact-container">
        <h2>Contact Us</h2>
        <form>
          <input type="text" placeholder="Your Name">
          <input type="email" placeholder="Your Email">
          <textarea placeholder="Your Message"></textarea>
          <button type="submit">Send Message</button>
        </form>
      </div>
    </section>
    <!-- end of ContactUs -->

  </main>
  
</body>




  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style scoped>
body {
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif, sans-serif;
    line-height: 1.6;
    margin: 0;
    padding: 0;
    background-color: #FFFFFF;
    color: rgb(236, 217, 217);
  }
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
