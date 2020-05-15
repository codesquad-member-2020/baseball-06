const fetchData = (callback,url) => {
    fetch(url)
    .then(res => res.json())
    .then(data => callback(data.body));
}


export default fetchData;