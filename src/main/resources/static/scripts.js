document.getElementById('reservationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const phone = event.target.phone.value;

    // 전화번호 형식 검사 (숫자만 입력했는지)
    if (!/^\d+$/.test(phone)) {
        alert('휴대폰 번호는 숫자만 입력해주세요.');
        return;
    }

    fetch('/api/reservation', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ phone: phone }),
    })
    .then(response => response.json())
    .then(data => {
        alert('링크가 전송되었습니다.');
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

document.getElementById('featureVideo').addEventListener('click', function() {
    alert('핵심 기능 시연 비디오가 재생됩니다.');
});
