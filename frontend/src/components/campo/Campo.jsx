import "./Campo.css";

function Campo({
    label,
    name,
    value,
    handleChange
}) {
    return (
        <div className="campo">
            <label>{label}</label>
            <input name={name} value={value} onChange={handleChange} type="number" />
        </div>
    )
}

export default Campo; 