function getYoutube(title, artist) {
    var API_KEY = "AIzaSyDQSVysWES54RDYnjZtfbmftS1K6WlBpVQ";
    var search = title + artist;
    var maxResults = 1


    API_KEY = "API_개인키";

    var url = `https://www.googleapis.com/youtube/v3/search?key=${API_KEY}
          &part=snippet&q=${search}&maxResults=${maxResults}&type=video`;

    $.ajax({
        method: "GET",
        url: url,
        success: function (data) {
            console.log(data);
            goYoutube(data);
        },
    });

    function goYoutube(data) {
        data.items.forEach((item) => {
            window.open(`https://www.youtube.com/watch?v=${item.id.videoId}>`);
        });
    }
} //Youtube API를 통해 해당 링크로 연결해주는 함수, 매개변수로 저작물명과 아티스트명을 받아 검색어로 설정하고 그에 해당하는 videoID를 이용해 페이지 이동
