import axios from 'axios';

axios.defaults.baseURL = "http://localhost:8080"

const getCompanylist = () => {
    axios.get('/company/1')
      .then(function (response) {
        // handle success
        console.log(response);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .then(function () {
        // always executed
      });
}