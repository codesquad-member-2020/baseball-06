const fetchData = (callback,url) => {
    fetch(url)
    .then(res => res.json())
    .then(data => callback(data.body));
    console.log(2)

}


// const fetchData =  (callback,url) => {
//     console.log(1)
//   const fetchData = async () => {
//     const res = await fetch(url);
//     const data = await res.json();
//     callback(data);
//     console.log(2)

//   } 
// }

export default fetchData;