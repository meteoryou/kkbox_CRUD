<template>
  <b-card title="聯絡人">
    <b-table striped hover :fields="fields" :items="contactList" foot-clone>

      <template v-slot:cell()="row">
        <span> {{row.item[row.field.key]}}</span>
      </template>
      <template v-slot:cell(button)="row">
        <b-button @click="handleClickDelete(row)"> － </b-button>
      </template>

       <template v-slot:foot()="data">
        <b-form-input v-model="inputData[data.column]" maxlength="60"></b-form-input>
      </template>

      <template v-slot:foot(button)>
        <b-button @click="handleClickAdd()"> ＋ </b-button>
      </template>
    </b-table>
  </b-card>
</template>

<script>
export default {
  props: ['contactList'],
  mounted() {

  },
  data() {
    return {
      name: "ContactList",
      fields: [
        { key: "name", label: "姓名" },
        { key: "jobTitle", label: "職稱" },
        { key: "phoneNum", label: "電話" },
        { key: "email", label: "Email" },
        { key: "button", label: "" }
      ],
      inputData : {
          name : '',
          jobTitle : '',
          phoneNum : '',
          email : '',
      }
    };
  },
  methods: {
    handleClickAdd : function(){
      this.contactList.push({...this.inputData});
      this.inputData = {
          name : '',
          jobTitle : '',
          phoneNum : '',
          email : '',
      };
    },
    handleClickDelete : function(row){
      this.contactList.splice(row.index, 1);
    }
  }
};
</script>