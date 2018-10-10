<template>
  <div style="display:flex;">  
		<section id="own-apps" class="item-table" style="flex:1">
			<aside class="item-title">
				<h3>我的项目</h3>
			</aside>
			<aside>
				<div  :key="app.appCode" v-for="app in appList" class="item-default" v-on:click="visitAppDetail(app.appCode)">
					<h4 style="margin-bottom: 0;">{{app.appName}}</h4>
					<h6 style="margin-top: 0;">{{app.appCode}}</h6>
				</div>
			</aside>
		</section>
	</div>
</template>
<script>
export default {
  data: function() {
    return {
      appList: []
    };
  },
  mounted: function() {
    this.loadAppList();
  },
  methods: {
    loadAppList: function() {
      this.axios.get("/app/list").then(resp => {
        this.appList = resp.data;
      });
    },
    visitAppDetail: function(appCode) {
      // this.$router.push({
      //   name: "appConfig",
      //   query: {
      //     appCode: appCode
      //   }
      // });
      const { href } = this.$router.resolve({
        name: "appConfig",
        query: {
          appCode: appCode
        }
      });
      window.open(href, "_blank");
    }
  },
  components: {
  }
};
</script>
<style>
:root {
  --border-color: #bebcbc;
}

.item-table {
  width: 100%;
  display: table;
}

.item-title {
  display: table-cell;
  width: 20%;
  text-align: center;
  vertical-align: middle;
  color: #fff;
  background-color: #373d41;
  border: solid 1px var(--border-color);
}

.item-default {
  display: table-cell;
  width: 20%;
  text-align: center;
  vertical-align: middle;
  border: solid 1px var(--border-color);
  border-radius: 25px;
  margin: 10px;
  float: left;
  cursor: pointer;
}

.item-default:hover {
  background-color: #608ebe;
}
</style>


