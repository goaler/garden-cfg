<template>
    <div>

		<section id="own-apps" class="item-table">
			<aside class="item-title">
				<h3>我的项目</h3>
			</aside>
			<aside>
				<div  :key="app.code" v-for="app in appList" class="item-default" v-on:click="visitAppDetail(app.code)">
					<h4 style="margin-bottom: 0;">{{app.name}}</h4>
					<h6 style="margin-top: 0;">{{app.code}}</h6>
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
      window.open("/page/appDetail.html?appCode=" + appCode);
    }
  }
};
</script>
<style>
.item-table {
  width: 100%;
  display: table;
}

.item-title {
  display: table-cell;
  width: 20%;
  text-align: center;
  vertical-align: middle;
  color: var(--wordColor);
  background-color: var(--panel1);
  border: solid 1px var(--border1);
}

.item-default {
  display: table-cell;
  width: 20%;
  text-align: center;
  vertical-align: middle;
  border: solid 1px var(--border1);
  border-radius: 25px;
  margin: 10px;
  float: left;
  cursor: pointer;
}

.item-default:hover {
  background-color: var(--hover1);
}
</style>


