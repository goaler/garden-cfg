<template>
  <center-panel>
        <h1>创建应用</h1>
        <label class="from-label">应用名称 : </label><input type="text" title="应用名称" class="input-text"/>
  </center-panel>
</template>
<script>
import '@/from.css';
import centerPanel from '@/components/CenterPanel'

export default {
  data: function() {
    return {
      appInfo: []
    };
  },
  mounted: function() {
   
  },
  methods: {
    loadAppList: function() {
     
    },
    visitAppDetail: function(appCode) {
      
    }
  },
  components: {
      centerPanel
  }
};
</script>
<style>
</style>


