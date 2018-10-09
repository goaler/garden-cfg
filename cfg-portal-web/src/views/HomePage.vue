<template>
  <div style="display:flex;">
    <div @mouseover="isCollapse=false" @mouseout="isCollapse=true" class="navPanel">
          <el-menu
            default-active="1"
            class="el-menu-vertical-demo"
            :collapse="isCollapse"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <router-link to="/appPage">
              <el-menu-item index="1">
                <i class="el-icon-location"></i>
                <span slot="title">首  页</span>
              </el-menu-item>
            </router-link>
            <router-link to="/clusterPage">
              <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">集群管理</span>
              </el-menu-item>
            </router-link>
            <router-link to="/envPage">
              <el-menu-item index="3">
                <i class="el-icon-document"></i>
                <span slot="title">环境管理</span>
              </el-menu-item>
            </router-link>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title">用户管理</span>
            </el-menu-item>
          </el-menu>
    </div>    
		<div style="flex:1" class="contentPanel">
      <router-view></router-view>
		</div>
	</div>
</template>
<script>
export default {
  data: function() {
    return {
      isCollapse:true
    };
  }
};
</script>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
  }

  .navPanel {
    margin-top: 20px;
  }

  .contentPanel {
    margin-top: 20px;
    margin-left: 20px;
  }
</style>

