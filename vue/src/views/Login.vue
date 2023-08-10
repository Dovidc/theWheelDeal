<template>
  <div id="login">
    
  <form @submit.prevent="login" class="login-form">
    <h1 class="login-title">Welcome to The Wheel Deal</h1>
    <div role="alert" v-if="invalidCredentials" class="alert alert-danger">
      Invalid username and password!
    </div>
    <div role="alert" v-if="$route.query.registration" class="alert alert-success">
      Thank you for registering. Please sign in.
    </div>
    <div class="form-input-group">
      <label for="username">Username</label>
      <input type="text" id="username" v-model="user.username" required autofocus />
    </div>
    <div class="form-input-group">
      <label for="password">Password</label>
      <input type="password" id="password" v-model="user.password" required />
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
    <p class="signup-link">
      <router-link :to="{ name: 'register' }">Don't have an account? Sign up.</router-link>
    </p>
  </form>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f8fb;
}

.login-form {
  width: 350px;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}

.login-title {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}

.form-input-group {
  margin-bottom: 15px;
  margin-right: 20px;
}

label {
  display: block;
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 5px;
  color: #555;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn-primary {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.signup-link {
  margin-top: 15px;
  text-align: center;
  font-size: 14px;
  color: #777;
}

.alert {
  padding: 10px;
  border-radius: 4px;
  margin-bottom: 10px;
  font-size: 14px;
}

.alert-danger {
  background-color: #f8d7da;
  color: #721c24;
}


.alert-success {
  background-color: #d4edda;
  color: #155724;
}


</style>