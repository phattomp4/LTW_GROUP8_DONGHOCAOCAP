let scrollAmount = 0;
const scrollStep = 300;

function scrollSlider(direction) {
    const slider = document.getElementById("slide-list-img");
    const maxScroll = slider.scrollWidth - slider.clientWidth;

    scrollAmount += direction * scrollStep;

    if (scrollAmount < 0) scrollAmount = 0;
    if (scrollAmount > maxScroll) scrollAmount = maxScroll;

    slider.scrollTo({
        left: scrollAmount,
        behavior: "smooth"
    });
}
