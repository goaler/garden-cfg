<template>
  <div class="loginPanel">
		<div style="height: 60px">
			<h1>cfg配置中心</h1>
		</div>
		<div>
			<input v-model="userCode" placeholder="用户名" type="text" />
		</div>
		<div>
			<input v-model="password" placeholder="密码" type="password" />
		</div>
		<div style="color: red">{{tips}}</div>
		<div>
			<input type="button" value="登    录" v-on:click="login()"
				class="btn btn-login" />
		</div>
	</div>
</template>

<script>
export default {
  data: function() {
    return {
      userCode: "",
      password: "",
      tips: ""
    };
  },
  methods: {
    login: function() {
      this.axios.post("/cfg/login", this.$data).then(resp => {
        if (resp.data == true) {
          this.$router.push("/");
        } else {
          this.tips = "账号或密码错误！";
        }
      });
    }
  }
};
</script>

<style scoped>
.loginPanel {
  margin: auto;
  width: 400px;
  height: 350px;
  text-align: center;
  border: solid 1px rgb(168, 157, 157);
  border-radius: 25px;
}

.loginPanel div {
  padding: 10px 20px 10px 20px;
}

.loginPanel input {
  padding-left: 10px;
  padding-right: 10px;
  font-size: 20px;
  height: auto;
  width: 90%;
  border-radius: 10px;
}

.btn-login {
  font-weight: bold;
  background-color: #e2e6f7;
  color: #2d3b55;
  padding: 6px 12px;
  border: solid 1px rgb(168, 157, 157);
  cursor: pointer;
}

.btn:hover {
  background-color: #a1eeea;
}
</style>
