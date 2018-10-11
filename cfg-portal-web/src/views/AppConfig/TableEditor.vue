<template>
	<div>
			<div>
				<button @click="showAddPropDlg()" class="btn" style="float: right;">新增配置</button>
			</div>
			<div style="width:100%;max-height:600px;overflow:auto;">
				<table class="table-editor">
					<thead>
						<th >状态</th>
						<th >Key</th>
						<th >Value</th>
						<th >备注</th>
            <th >创建人</th>
            <th >创建时间</th>
            <th >修改人</th>
            <th >修改时间</th>
						<th >操作</th>
					</thead>
					<tbody>
						<tr v-for="p in docProps" :key="p.itemId">
							<td>{{p.status}}</td>
							<td>{{p.key}}</td>
							<td>{{p.value}}</td>
							<td>{{p.comment}}</td>
              <td>{{p.createUserCode}}</td>
              <td>{{p.createTime | formatDateStr}}</td>
              <td>{{p.updateUserCode}}</td>
              <td>{{p.updateTime | formatDateStr}}</td>
							<td>
								<button @click="deleteProp(p.itemId)">删除</button>
								<button @click="showUpdatePropDlg(p)">修改</button>
							</td>
						</tr>
					</tbody>
					<tfoot>
					</tfoot>
				</table>
			</div>
			<prop-dialog :dlgdisplay.sync="addPropDialogDisplay" @ensure-click="addProp"></prop-dialog>
			<prop-dialog :dlgdisplay.sync="updatePropDialogDisplay" @ensure-click="updateProp" :prop="currentUpdateProp"></prop-dialog>
		</div>
</template>
<script>
import PropDialog from "./PropDialog";

export default {
  props: {
    doc: Object,
    /* 存放属性列表 */
    docProps: Array
  },
  data: function() {
    return {
      addPropDialogDisplay: false,
      updatePropDialogDisplay: false,
      currentUpdateProp: null
    };
  },
  mounted: function() {},
  methods: {
    showAddPropDlg: function() {
      this.addPropDialogDisplay = true;
    },
    addProp: function(p) {
      var vm = this;
      this.axios.post("/doc/props/" + this.doc.docId, [p]).then(resp => {
        if (resp.data == true) {
          alert("配置项添加成功！！！");
        }
        vm.$parent.fetchDocProps();
      });
    },
    deleteProp: function(itemId) {
      var vm = this;
      this.axios
        .delete("/doc/props/" + this.doc.docId, {
          data: [itemId]
        })
        .then(resp => {
          if (resp.data == true) {
            alert("配置项删除成功！！！");
          }
          vm.$parent.fetchDocProps();
        });
    },
    showUpdatePropDlg: function(prop) {
      this.currentUpdateProp = prop;
      this.updatePropDialogDisplay = true;
    },
    updateProp: function(p) {
      var vm = this;
      this.axios.put("/doc/props/" + this.doc.docId, [p]).then(resp => {
        if (resp.data == true) {
          alert("配置项修改成功！！！");
        }
        vm.$parent.fetchDocProps();
      });
    }
  },
  components:{
    PropDialog
  }
};
</script>
<style>
.table-editor {
	width: 100%;
	text-align: left;
	border: 1px solid var(--border-color);
	color: #666;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

.table-editor thead {

	background-color: #EBEBEC;
}

.table-editor td,
.table-editor th {
	border: 1px solid var(--border-color);
	padding: 10px 15px;
}

.table-editor tbody tr {
	cursor: pointer;
}

.table-editor tbody tr:hover {
	background-color: #a1c6ee;
}
</style>


