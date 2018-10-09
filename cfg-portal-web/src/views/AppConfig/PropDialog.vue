<template>
			<div v-if="dlgdisplay" class="dlgbg">
			<div class="dlg-panel">
				<div class="dialog-top">
				</div>
				<div class="dlg-content">
					<div class="ct-line">
						<label>Key : </label>
						<input v-model="p.key" type="text">
						<span style="font-weight: bold; color:red;font-size: 18px;">*</span>
					</div>
					<div class="ct-line">
						<label>Value : </label>
						<input v-model="p.value" type="text">
						<span style="font-weight: bold; color:red;font-size: 18px;">*</span>
					</div>
					<div class="ct-line">
						<label>注释 : </label>
						<input v-model="p.comment" type="text">
					</div>
				</div>
				<div class="dlg-foot">
					<button class="btn" @click="ensure()">提交</button>
					<button class="btn" @click="cancel()">取消</button>
				</div>
			</div>
		</div>
</template>
<script>
export default {
  props: {
    dlgdisplay: {
      require: true,
      type: Boolean
    },
    prop: Object
  },
  data: function() {
    return {
      p: {
        key: null,
        value: null,
        comment: null
      }
    };
  },
  methods: {
    cancel: function() {
      this.$emit("update:dlgdisplay", false);
    },
    ensure: function() {
      this.$emit("update:dlgdisplay", false);
      this.$emit("ensure-click", this.p);
    }
  },
  watch: {
    prop: function(newVal, oldVal) {
      if (newVal) {
        this.p = newVal;
      }
    }
  }
};
</script>
<style>
.dlgbg {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: #a9aaaa80;
}

.dlg-panel {
  position: relative;
  background-color: #f8f6f688;
  width: 600px;
  height: 300px;
  border: solid 1px var(--border-color);
  border-radius: 10px;
  margin: 100px auto;
}

.dlg-content {
  margin: 30px;
}

.dlg-foot {
  position: absolute;
  text-align: center;
  width: 100%;
  bottom: 50px;
}

.ct-line {
  margin: 20px 0;
  height: 30px;
  text-align: center;
}

.ct-line label {
  width: 30%;
  height: 100%;
  font-weight: bold;
}

.ct-line input {
  margin-left: 10px;
  width: 60%;
  height: 90%;
  border-radius: 5px;
}
</style>


