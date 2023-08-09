<template>
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
</template>

<script>
export default {

}
</script>

<style>

</style>