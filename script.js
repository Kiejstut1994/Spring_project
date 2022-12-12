document.addEventListener('DOMContentLoaded', function(event) {
    fetch(`http://localhost:8080/books/helloBook`, {
        method: 'GET',
    })
        .then(function (response) {
            if (response.ok) {
                console.log(response);
                return response.json();
            }
            throw new Error("Oops...")
        })
});