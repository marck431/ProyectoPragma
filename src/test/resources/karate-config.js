function fn() {
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('ssl', true);

     var baseUrl = karate.properties['baseUrl'] || 'https://pruebapragma-9bb86-default-rtdb.firebaseio.com/person'


    return {
        url:{
             urlBase: baseUrl
        },
        path:{
        client: '/client.json',
        employee: '/employee.json'
        }
    };
}