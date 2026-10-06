"use strict";
const common_vendor = require("../../common/vendor.js");
const _sfc_main = {
  __name: "register",
  setup(__props) {
    const studentNo = common_vendor.ref("");
    const name = common_vendor.ref("");
    const register = () => {
      common_vendor.index.__f__("log", "at pages/register/register.vue:14", "学号:", studentNo.value);
      common_vendor.index.__f__("log", "at pages/register/register.vue:15", "姓名", name.value);
    };
    return (_ctx, _cache) => {
      return {
        a: name.value,
        b: common_vendor.o(($event) => name.value = $event.detail.value, "f8"),
        c: common_vendor.o(register, "ad")
      };
    };
  }
};
wx.createPage(_sfc_main);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/register/register.js.map
