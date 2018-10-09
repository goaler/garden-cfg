<template>
  <div id="app">
    <div class="headPanel">
		  <router-link to="/" style="margin-left:50px;text-decoration:none;color: #fff;"><span style="font-size: 25px;font-weight:bold">主页</span></router-link>
	  </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

.headPanel {
  line-height: 60px;
  background-color: #545c64;
  height: 60px;
  color: #fff;
}
</style>
