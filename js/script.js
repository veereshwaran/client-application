$(document).ready(function () {

    whoami();
    getuser();

});

function whoami() {
     // process the form
     $.ajax({
         type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
         url: '/auth/user/whoami', // the url where we want to POST
         datatype: "json", // what type of data do we expect back from the serve
         headers: {
             "x-auth-token": window.localStorage.getItem('access_token')
         },
         statusCode: {
             401: function () {
                 window.location = '/logout';
                //  alert('Invalid User name or Password');
             }
         }
     });
}

function getuser() {
     // process the form
     $.ajax({
         type: 'GET',
         url: '/auth/user',
         datatype: "json",
         statusCode: {
             200: function (request) {
                 getUserInfo(request);
             },
             401: function () {
                 window.location = '/logout';
                //  alert('Invalid User name or Password');
             }
         }
     });
}

function getUserInfo(request) {

  var userValue = request;

  var userTBody = document.getElementById('userTBody');
  var tr = document.createElement('tr');

  var td = document.createElement('td');
  var td1 = document.createElement('td');
  var td2 = document.createElement('td');
  var td3 = document.createElement('td');
  var td4 = document.createElement('td');

  td.appendChild(document.createTextNode(userValue.name));
  td1.appendChild(document.createTextNode(userValue.authorities[0].authority));
  td2.appendChild(document.createTextNode(userValue.details.sessionId));
  td3.appendChild(document.createTextNode(userValue.oauth2Request.clientId));
  td4.appendChild(document.createTextNode(userValue.details.tokenValue));

  tr.appendChild(td);
  tr.appendChild(td1);
  tr.appendChild(td2);
  tr.appendChild(td3);
  tr.appendChild(td4);

  userTBody.appendChild(tr);
}
