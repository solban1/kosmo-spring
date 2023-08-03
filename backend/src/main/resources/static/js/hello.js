export default function(hello) {
    if (typeof hello === "string") {
        return hello;
    } else {
        return "hello";
    }
}