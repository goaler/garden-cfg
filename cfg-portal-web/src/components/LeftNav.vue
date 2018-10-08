<template>
    <div class="navPanel" @mouseover="showMenu" @mouseout="showMenu">
        <!-- <div v-show="menuState == 'show'" class="menuPanel">
            <div class="menuTiem">应用管理</div>
            <div class="menuTiem">用户管理</div>
            <div class="menuTiem">集群管理</div>
            <div class="menuTiem">环境管理</div>
        </div> -->
        <el-row class="tac">
  <el-col :span="12">
    <h5>默认颜色</h5>
    <el-menu >
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">导航二</span>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <i class="el-icon-document"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <span slot="title">导航四</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</el-row>
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


