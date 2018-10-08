<template>
  <div>
    <div style="line-height:60px;background-color: #00C1DE;height:60px;color:#fff;">
		  <router-link to="/" style="margin-left:50px;text-decoration:none"><span style="font-size: 25px;font-weight:bold">主页</span></router-link>
	  </div>
    	<div class="info-panel" v-cloak>
				<transition name="custom-classes-transition" enter-active-class="animated tada" leave-active-class="animated bounceOutRight">
					<div v-show="show" class="info-item">
						<div class="info-item-title">项目信息</div>
						<div v-bind:title="app.name">项目名称：{{app.name}}</div>
						<div v-bind:title="app.code">项目编号：{{app.code}}</div>
						<div v-bind:title="app.comment">项目描述：{{app.comment}}</div>
					</div>
				</transition>
				<transition name="custom-classes-transition" enter-active-class="animated tada" leave-active-class="animated bounceOutRight">
					<div v-show="show" class="info-item">
						<div class="info-item-title">所属环境</div>
						<select v-model="currentEnv">
							<option v-for="env in envs" :key="env.envCode" :value="env.envCode">{{ env.envName }}({{env.envCode}})</option>
						</select>
					</div>
				</transition>
				<transition name="custom-classes-transition" enter-active-class="animated tada" leave-active-class="animated bounceOutRight">
					<div v-show="show" class="info-item">
						<div class="info-item-title">所属集群</div>
						<select v-model="currentCluster">
							<option v-for="cluster in clusters" :key="cluster.clusterCode" :value="cluster.clusterCode">{{ cluster.clusterName}}({{cluster.clusterCode}})
							</option>
						</select>
					</div>
				</transition>
			</div>
    <div class="config-panel" v-cloak>
				<h4>配置管理</h4>
				<doc-config v-for="doc in docs" :key="doc.id" :doc="doc"></doc-config>
			</div>
  </div>
</template>
<script>
import DocConfig from './DocConfig.vue'
import { getUrlKey } from "../../utils/common.js";

export default {
  data:function() {
    return {
      show: false,
      app: {
        name: "",
        code: "",
        comment: ""
      },
      currentEnv: "",
      envs: [
        {
          envCode: "",
          envName: ""
        }
      ],
      currentCluster: "",
      clusters: [
        {
          clusterCode: "",
          clusterName: ""
        }
      ],
      docs: []
    }
  },
  mounted: function() {
    this.initPage();
    this.getAppInfo();
    this.findEnvs();
    this.findClusters();
  },
  methods: {
    initPage: function() {
      document.title += "-" + getUrlKey("appCode");
      this.show = true;
    },
    getAppInfo() {
      this.axios
        // .get('/app/info' + window.location.search)
        .get("/app/info?appCode=" + getUrlKey("appCode"))
        .then(resp => {
          if (resp.data) {
            this.app = resp.data;
          }
        });
    },
    findEnvs() {
      this.axios.get("/env/list").then(resp => {
        if (resp.data) {
          this.envs = resp.data;
          this.currentEnv = this.envs[0].envCode;
        }
      });
    },
    findClusters() {
      this.axios.get("/cluster/list").then(resp => {
        if (resp.data) {
          this.clusters = resp.data;
          this.currentCluster = this.clusters[0].clusterCode;
        }
      });
    },
     fetchDocs: function () {
            if (this.app.code && this.currentEnv && this.currentCluster) {
                var url = '/app/docs?appCode=' + this.app.code + '&envCode=' + this.currentEnv + '&clusterCode=' + this.currentCluster
                this.axios
                    .get(url)
                    .then(resp => {
                        this.docs = resp.data
                    })
            }
        }
  },
  watch: {
    app: function() {
      this.fetchDocs();
    },
    currentEnv: function() {
      this.fetchDocs();
    },
    currentCluster: function() {
      this.fetchDocs();
    }
  },
  components:{
    DocConfig
  }
};
</script>
<style>
:root {
  --btn-bg: #ebebec;
  --panel-bg: #ebf2f9;
  --border-color: #ddd;
  --hover-color: #a1c6ee;
}

.info-panel {
  position: absolute;
  width: 250px;
}

.config-panel {
  margin-left: 255px;
  min-width: 900px;
}

.info-item {
  margin: 20px;
  padding: 15px;
  background-color: var(--panel-bg);
  border: solid 1px var(--border-color);
  box-shadow: 0 2px 12px 0 rgba(0,0,0,.1)
}

.info-item div {
  overflow: hidden;
  text-overflow: ellipsis;
}

.info-item-title {
  font-weight: bold;
  font-size: 18px;
  padding-bottom: 10px;
}
</style>


