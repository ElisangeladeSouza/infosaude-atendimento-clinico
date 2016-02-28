$(document).ready(function () {
    $('.js-botao-sidebar').bind('click', function () {
        $('.js-sidebar').toggleClass('esta-oculto');
        $('.js-conteudo').toggleClass('esta-oculto');
    });
});
