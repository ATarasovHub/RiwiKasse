let products = [];

window.addEventListener('DOMContentLoaded', () => {
    fetch('products.json')
        .then(resp => resp.json())
        .then(data => {
            products = data;
            renderProducts();
        });

    document.getElementById('btn-calculate')
        .addEventListener('click', calculateTotal);

    const resetBtn = document.getElementById('btn-reset');
    if (resetBtn) {
        resetBtn.addEventListener('click', resetForm);
    }
});

function renderProducts() {
    const list = document.getElementById('product-list');
    list.innerHTML = '';

    products.forEach(product => {
        const row = document.createElement('tr');
        row.innerHTML = `
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td>
        <input 
          type="number" 
          min="0" 
          value="0" 
          data-id="${product.id}" 
          style="width:60px;"
        />
      </td>
    `;
        list.appendChild(row);
    });
}

function calculateTotal() {
    let total = 0;

    const inputs = document.querySelectorAll('#product-list input[type="number"]');
    inputs.forEach(input => {
        const qty = parseInt(input.value, 10);
        if (qty > 0) {
            const id = parseInt(input.getAttribute('data-id'), 10);
            const product = products.find(p => p.id === id);
            if (product) {
                total += product.price * qty;
            }
        }
    });

    document.getElementById('receipt').textContent = 'Sum: ' + total;
}

function resetForm() {
    const inputs = document.querySelectorAll('#product-list input[type="number"]');
    inputs.forEach(input => input.value = '0');
    document.getElementById('receipt').textContent = '';
}
