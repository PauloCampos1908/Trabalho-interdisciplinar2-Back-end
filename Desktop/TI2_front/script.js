// Botões do modal
const modal = document.getElementById("modal");
const openModalBtn = document.getElementById("openModalBtn");
const closeModalBtn = document.getElementById("closeModalBtn");

// Abrir modal
openModalBtn.addEventListener("click", () => {
  modal.style.display = "flex";
});

// Fechar modal
closeModalBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

// Fechar se clicar fora da janela
window.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.style.display = "none";
  }
});
