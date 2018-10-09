<template>
		<div class="doc-config">
			<ul class="menu">
				<li @click="currentPanel = 'table'" :class="['menu-item', currentPanel=='table'?'menu-item-cur':'']">列表</li>
				<li @click="currentPanel = 'text'" :class="['menu-item', currentPanel=='text'?'menu-item-cur':'']">文本</li>
			</ul>
			<div class="tab-panel">
				<div v-show="currentPanel == 'text'">
					<text-editor v-model="content"></text-editor>
				</div>
				<div v-show="currentPanel == 'table'">
					<table-editor :doc="doc" :doc-props="docProps"></table-editor>
				</div>
			</div>
		</div>
</template>
<script>
import { getUrlKey } from "../../utils/common"
import TextEditor from './TextEditor'
import TableEditor from './TableEditor'

export default {
  props: {
    doc: {
      require: true
    }
  },
  data: function() {
    return {
      currentPanel: "table",
      docProps: null,
      content: ""
    };
  },
  mounted: function() {
    this.fetchDocProps();
  },
  methods: {
    fetchDocProps: function() {
      var url = "/doc/props/" + this.doc.docId;
      this.axios.get(url).then(resp => {
        this.docProps = resp.data;
      });
    },
    computeContent: function(props) {
      var ret = "";
      if (props && props.length > 0) {
        for (let p of props) {
          ret += p.key + " = " + p.value + "\r\n";
        }
      }
      return ret;
    }
  },
  watch: {
    docProps: function(newVal, oldVal) {
      if (newVal) {
        this.content = this.computeContent(newVal);
      }
    }
  },
  components:{
    TextEditor,
    TableEditor
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

.doc-config {
  background-color: var(--panel-bg);
  margin: 20px 0px;
  padding: 20px 10px;
  border: solid 1px var(--border-color);
  border-radius: 25px;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
}

.tab-panel {
  padding: 20px 0px;
}

.menu {
  list-style: none;
  padding: 0px 20px;
  margin: 0px;
  border-top: 1px solid var(--border-color);
  border-bottom: 1px solid var(--border-color);
}

.menu-item {
  display: inline-block;
  cursor: pointer;
  padding: 10px 35px;
  margin: 0px 5px;
}

.menu-item-cur {
  background: var(--btn-bg);
}

.menu-item:hover {
  background-color: var(--hover-color);
}
</style>


