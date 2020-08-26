
<template>
  <div>
    <CompanyList :key="render"/>
    <b-button variant="info" @click="handleClickCreate">新增公司資料</b-button>
    <b-button @click="handleClickCancleCreate">取消</b-button>

    <CompanyForm v-if="isShowCreateForm" v-on:saveCompany="handleSaveCompany"/>
  </div>
</template>


<script>
import CompanyList from "../components/CompanyList";
import CompanyForm from "../components/CompanyForm";

export default {
  name: "CompanyContainer",
  data() {
    return {
      isShowCreateForm : false,
      render : 0
    }
  },
  components: {
    CompanyList,
    CompanyForm
  },
  methods: {
    handleClickCreate : function(){
        this.isShowCreateForm = true;
    },
    handleClickCancleCreate : function(){
        this.isShowCreateForm = false;
    },
    handleSaveCompany: function() {
      this.isShowCreateForm = false;
      this.render += 1;
    }
  }
};
</script>
