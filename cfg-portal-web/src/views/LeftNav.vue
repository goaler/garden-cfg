<template>
    <div class="navPanel" @mouseover="showMenu" @mouseout="showMenu">

	    <btn @click="showMenu" class="navMenuCtl"  ></btn>
	</div>
</template>
<script>
export default {
  data: function() {
    return {
      menuState: "hide"
    };
  },
  mounted: function() {},
  methods: {
    showMenu: function() {
      this.menuState = "show";
    },
    hideMenu: function() {
      this.menuState = "hide";
    }
  }
};
</script>
<style>
.navPanel {
  height: 1200px;
  min-height: 100%;
}

.menuPanel {
  float: left;
  margin: 0;
  width: 20%;
  max-width: 300px;
  min-width: 200px;
  height: 100%;
}

.menuTiem {
  line-height: 40px;
  background-color: #5fb878;
}

.navMenuCtl {
  float: left;
  height: 100%;
  width: 20px;
  background-color: #b8b8c2;
  margin: 0;
}
</style>


