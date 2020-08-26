<template>
  <div>
    <!-- <b-card title="已儲存廠商">
      <b-table striped hover :fields="fields" :items="items"></b-table>
    </b-card> -->

    <b-card title="已儲存廠商">
      <b-table :items="companyList" :fields="fields" striped responsive="sm"> 
        <template v-slot:cell(showDetails)="row">
          <b-button
            size="sm"
            @click="handleClickCompany(row)"
            class="mr-2"
          >{{ row.detailsShowing ? '取消' : '編輯'}}</b-button>
          <b-button size="sm" class="mr-2" @click="handleDeleteCompany(row)">刪除</b-button>

          <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
          <!-- <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">Details via check</b-form-checkbox> -->
        </template>

        <template v-slot:row-details="row">
          <CompanyForm :companyData="companyData" v-on:saveCompany="handleSaveCompany(row)" />
        </template>
      </b-table>
     </b-card>
  </div>
</template>

<script>
import CompanyForm from "./CompanyForm";
import axios from 'axios';


export default {
  props : ['saveCompany'],
  mounted() {
    this.getCompanyList();
  },
  data() {
    return {
      companyList: [],
      companyData: {},
      name: "CompanyList",
      fields: [
        { key: "name", label: "公司名稱" },
        { key: "taxId", label: "統一編號" },
        { key: "phoneNum", label: "電話" },
        { key: "fillIn", label: "填單人" },
        { key: "updateDt", label: "更新時間" },
        { key: "showDetails", label: "" }
      ],
    };
  },
  components: {
    CompanyForm
  },
  methods: {
    handleClickCompany : function(row) {
      this.companyData = row.item;
      row.toggleDetails();
    },
    handleDeleteCompany : function(row){
      axios.delete('http://127.0.0.1:8080/company/delete/' + row.item.id, row.item)
        .then((response) => {
            console.log(response);
            this.getCompanyList();
          })
          .catch((error) => {
            // handle error
            console.log(error);
          })
          .then(() => {
            // always executed
          });
    },
    handleSaveCompany: function(row){
      row.toggleDetails();
      this.getCompanyList();
    },
    handleClickSaveEdit: function(row){
      row.toggleDetails();
    },
    getCompanyList : function(){
      axios.get('http://127.0.0.1:8080/company/list')
    .then((response) => {
        // handle success
        this.companyList = response.data;
      })
      .catch((error) => {
        // handle error
        console.log(error);
      })
      .then(() => {
        // always executed
      });
    },
  }
};
</script>