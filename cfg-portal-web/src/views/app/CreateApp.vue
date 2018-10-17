<template>
  <center-panel>
    <h1>创建应用</h1>
      <div class="input-line">
        <label class="from-label">应用名称 : </label><input type="text" placeholder="应用名称" class="input-text"/>
      </div>
      <div class="input-line">
        <label class="from-label">应用编号 : </label><input type="text" placeholder="应用编号" class="input-text"/>
      </div>
      <div><label class="from-label">描 述 : </label></div>
      <div class="input-line">
        <label class="from-label"></label><textarea placeholder="应用简述" rows="5" cols="55" class="input-textarea"/>
      </div>
  </center-panel>
</template>
<script>
import centerPanel from "@/components/CenterPanel";

export default {
  data: function() {
    return {
      appInfo: []
    };
  },
  mounted: function() {},
  methods: {
    loadAppList: function() {},
    visitAppDetail: function(appCode) {}
  },
  components: {
    centerPanel
  }
};
</script>
<style>
.from-label{
    padding: 10px 20px 10px 0px;
    display:inline-block;
    width: 100px;
    text-align: right;
   
}

.input-text{
    width: 400px;
}

.input-line{
  
}
</style>


