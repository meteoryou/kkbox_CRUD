<template>
  <div>
    <b-container class="bv-example-row">
      <b-card title="廠商基本資料">
        <b-row class="my-1">
          <b-col md="2">
            <label>*填單人</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.fillIn" maxlength="60"></b-form-input>
          </b-col>
          <b-col md="2">
            <label>*公司名稱</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.name" maxlength="60"></b-form-input>
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col md="2">
            <label>*統一編號</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.taxId" maxlength="8"></b-form-input>
          </b-col>
          <b-col md="2">
            <label>*負責人</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.owner" maxlength="60"></b-form-input>
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col md="2">
            <label>*地址</label>
          </b-col>
          <b-col md="10">
            <b-form-input v-model="initCompanyData.address" maxlength="250"></b-form-input>
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col md="2">
            <label>電話</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.phoneNum" maxlength="50"></b-form-input>
          </b-col>
          <b-col md="2">
            <label>傳真</label>
          </b-col>
          <b-col md="4">
            <b-form-input v-model="initCompanyData.fax" maxlength="50"></b-form-input>
          </b-col>
        </b-row>

        <b-row class="my-1">
          <b-col md="2">
            <label>備註</label>
          </b-col>
          <b-col md="10">
            <b-form-textarea v-model="initCompanyData.comment" maxlength="500"></b-form-textarea>
          </b-col>
        </b-row>
      </b-card>
      <ContactList v-bind:contact-list="contactList"/>
      <b-button variant="info" @click="handleClickSave">儲存</b-button>

      <b-modal v-model="isShowValid">{{ invalidCol }} 為必填欄位</b-modal>
    </b-container>
  </div>
</template>

<script>
import ContactList from "./ContactList";
import axios from 'axios';

export default {
  props: ['companyData', 'isShowDetail'],
  mounted(){
    if(this.initCompanyData.id){
      axios.get('http://127.0.0.1:8080/contact/' + this.initCompanyData.id)
      .then((response) => {
          // handle success
          this.contactList = response.data;
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .then(() => {
          // always executed
        });
    }
  },
  data() {
    return {
      showContact: false,
      name: "CompanyForm",
      contactList: [],
      initCompanyData: { ...this.companyData } || {},
      isShowCompanyDetail: this.isShowDetail,
      isShowValid: false,
      invalidCol: ""
     };
  },
  components: {
    ContactList
  },
  methods: {
    handleClickSave: function() {
        this.initCompanyData.contactList = Object.assign(this.contactList);
        const postData = this.initCompanyData;

        if(this.validation()){
          axios.post('http://127.0.0.1:8080/company/saveCompany', postData)
          .then((response) => {
              // handle success
              console.log(response);
  
              this.$emit('saveCompany');
            })
            .catch((error) => {
              // handle error
              console.log(error);
            })
            .then(() => {
              // always executed
            });
        }else{
          this.isShowValid = true;
        }
    },
    validation: function() {
      
      let result = true;
      this.invalidCol = "";

      if(!this.initCompanyData.fillIn){
        result = false;
        this.invalidCol += "填單人";
      }
      if(!this.initCompanyData.name){
        result = false;
        this.invalidCol += " 公司名稱";
      }
      if(!this.initCompanyData.taxId){
        result = false;
        this.invalidCol += " 統一編號";
      }
      if(!this.initCompanyData.owner){
        result = false;
        this.invalidCol += " 負責人";
      }
      if(!this.initCompanyData.address){
        result = false;
        this.invalidCol += " 地址";
      }
      

      return result;
    }
  }
};
</script>