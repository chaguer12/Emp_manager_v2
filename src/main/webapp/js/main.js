// Modal functionality (add this inside a script tag or external JS file)
document.querySelector('.open-modal-btn').addEventListener('click', function () {
    document.getElementById('addOfferModal').style.display = 'block';
});

document.querySelector('.close-btn').addEventListener('click', function () {
    document.getElementById('addOfferModal').style.display = 'none';
});

// Close the modal if clicked outside the modal content
window.onclick = function (event) {
    if (event.target == document.getElementById('addOfferModal')) {
        document.getElementById('addOfferModal').style.display = 'none';
    }
};