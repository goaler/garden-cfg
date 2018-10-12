<template>
    <div>
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column
            prop="clusterCode"
            label="集群编号">
            </el-table-column>
            <el-table-column
            prop="clusterName"
            label="集群名称">
            </el-table-column>
            <el-table-column
            prop="comment"
            label="备注">
            </el-table-column>
            <el-table-column
            prop="status"
            label="状态">
            </el-table-column>
            <el-table-column
            prop="createUserCode"
            label="创建人">
            </el-table-column>
            <el-table-column
            prop="createTime"
            :formatter="util.eleUIFormatDate"
            label="创建时间">
            </el-table-column>
            <el-table-column
            prop="updateUserCode"
            label="修改人">
            </el-table-column>
            <el-table-column
            prop="updateTime"
            :formatter="util.eleUIFormatDate"
            label="修改时间">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
  data: function() {
    return {
      tableData: []
    };
  },
  mounted: function() {
    this.loadList();
  },
  methods: {
    loadList: function() {
      this.axios.get("/cluster/list").then(resp => {
        this.tableData = resp.data;
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
  }
};
</script>