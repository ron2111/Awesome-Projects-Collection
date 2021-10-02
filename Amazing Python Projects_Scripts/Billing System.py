from tkinter import *
import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
import sqlite3


def update(rows):
    trv.delete(*trv.get_children())
    for i in rows:
        trv.insert("", "end", values=i)


def clearfields():
    pid.set("")
    pn.set("")
    pc.set("")
    pq.set("")
    pp.set("")


def sellproduct():
    if pn.get() != "" and pc.get() != "" and pq.get() != "" and pp.get() != "":
        if int(pq.get()) == 0:
            tk.messagebox.showerror(
                "Product not Available", pn.get() + " is not available"
            )
            return
        result = tk.messagebox.askquestion(
            "Sell Product", "Sell this product\n" + str(pn.get())
        )
        if result == "yes":
            pq.set(int(pq.get()) - 1)
            update_product()
            getTotal()
    else:
        tk.messagebox.showerror("Product not selected", "Select the product to sell")


def search():
    q2 = q.get()
    # query = "Select * from products where pname LIKE ?", ("%" + q2 + "%",)
    # mydb.execute(query)
    c.execute("SELECT * FROM products WHERE pname LIKE ?", ("%" + q2 + "%",))
    rows = c.fetchall()
    update(rows)


def getTotal():
    price = c.execute("Select (pprice*pquantity) from products")
    return total.set(sum((i[0] for i in price)))


def clear():
    query = "Select * from products"
    c.execute(query)
    rows = c.fetchall()
    update(rows)


def getrow(event):
    rowid = trv.identify_row(event.y)
    item = trv.item(trv.focus())

    pid.set(item["values"][0])
    pn.set(item["values"][1])
    pc.set(item["values"][2])
    pq.set(item["values"][3])
    pp.set(item["values"][4])


def update_product():
    p_name = pn.get()
    p_category = pc.get()
    p_quantity = pq.get()
    p_price = pp.get()
    p_id = pid.get()

    if messagebox.askyesno("Confirm Please", "Are you sure want to update?"):
        query = "UPDATE products set pname=?, pcategory=?, pquantity=?, pprice=? where pid = ?"
        mydb.execute(query, (p_name, p_category, p_quantity, p_price, p_id))
        mydb.commit()
        clear()
        getTotal()
    else:
        return True


def add_product():
    p_name = pn.get()
    p_category = pc.get()
    p_quantity = pq.get()
    p_price = pp.get()
    if p_name != "" and p_category != "" and p_quantity != "" and p_price != "":
        query = "Insert into products values (NULL,?, ?, ?, ?)"
        mydb.execute(query, (p_name, p_category, p_quantity, p_price))
        mydb.commit()
        clear()
        pid.set("")
        pn.set("")
        pc.set("")
        pq.set("")
        pp.set("")
        getTotal()
    else:
        tk.messagebox.showerror("Field Empty", "Please fill all the fields!")


def delete_product():
    p_id = pid.get()
    p_name = pn.get()
    if pid != "" and p_name != "":
        if messagebox.askyesno(
            "Delete Confirmation", "Are you sure to delete this product?"
        ):
            query = "Delete from products where pid = " + p_id
            mydb.execute(query)
            mydb.commit()
            clear()
            pid.set("")
            pn.set("")
            pc.set("")
            pq.set("")
            pp.set("")
            getTotal()
        else:
            True
    else:
        tk.messagebox.showerror("Field Empty", "Select the product to delete")


# mydb = mysql.connector.connect(
#     host="localhost",
#     user="root",
#     passwd="",
#     database="shop",
#     auth_plugin="mysql_native_password",
# )
# mydb = mydb.mydb()

mydb = sqlite3.connect("product_data.db")
c = mydb.cursor()

# mydb.execute(
#     """CREATE TABLE products (
#     pid integer PRIMARY KEY,
#     pname text,
#     pcategory text,
#     pquantity integer,
#     pprice integer)"""
# )


root = Tk()
q = StringVar()

pn = StringVar()
pc = StringVar()
pq = StringVar()
pp = StringVar()
pid = StringVar()
total = StringVar()


wrapper1 = LabelFrame(
    root,
    text="Product List",
    bg="INDIANRED",
    font=("Helvetica", 15, "bold"),
    fg="white",
)
wrapper2 = LabelFrame(
    root, text="Search", bg="lightgreen", font=("Helvetica", 15, "bold"), fg="white",
)
wrapper3 = LabelFrame(
    root,
    text="Add product",
    bg="lightblue",
    font=("Helvetica", 15, "bold"),
    fg="white",
)

wrapper1.pack(fill="both", expand="no", pady=3)
wrapper2.pack(fill="both", expand="no", pady=3)
wrapper3.pack(fill="both", expand="no", pady=0)

trv = ttk.Treeview(wrapper1, columns=(1, 2, 3, 4, 5), show="headings", height="8")
trv.pack()

trv.heading(1, text="Product ID")
trv.heading(2, text="Product Name")
trv.heading(3, text="Product Category")
trv.heading(4, text="Product Quantity")
trv.heading(5, text="Product Price")

trv.bind("<Button 1>", getrow)

style = ttk.Style()
style.configure(".", font=("Helvetica", 10, "bold"), foreground="white")
style.configure("Treeview.Heading", foreground="green")
style.configure("BW.TLabel", foreground="black", background="white")

query = "Select * from products"
c.execute(query)
rows = c.fetchall()
print(rows)
update(rows)
getTotal()

# Search Section

lbl = Label(wrapper2, text="Search", font=(20))
lbl.pack(side=tk.LEFT, padx=10)
ent = Entry(wrapper2, textvariable=q, width="40", font=(20))
ent.pack(side=tk.LEFT, padx=6, ipady=5)
btn = Button(
    wrapper2,
    text="Search",
    command=search,
    bg="INDIANRED",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
)
btn.pack(side=tk.LEFT, padx=6)
cbtn = Button(
    wrapper2,
    text="Clear",
    command=clear,
    bg="GREY",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
)
cbtn.pack(side=tk.LEFT, padx=6)


# Product Data Section
lbl5 = Label(wrapper3, text="Product Name").grid(row=0, column=0, padx=5, pady=3)
ent5 = Entry(wrapper3, textvariable=pid, state="disabled", width="40", font=(20)).grid(
    row=0, column=1, padx=5, pady=3, ipady=5
)

lbl1 = Label(wrapper3, text="Product Name").grid(row=1, column=0, padx=5, pady=3)
ent1 = Entry(wrapper3, textvariable=pn, width="40", font=(20)).grid(
    row=1, column=1, padx=5, pady=3, ipady=5
)

lbl2 = Label(wrapper3, text="Product Category").grid(row=2, column=0, padx=5, pady=3)
# ent2 = Entry(wrapper3, textvariable=pc, width="40", font=(20)).grid(
#     row=2, column=1, padx=5, pady=3, ipady=5
# )

l1 = ["Stationery", "Mobile"]
droplist = OptionMenu(wrapper3, pc, *l1)
droplist.config(width=52)
pc.set("Stationery")
droplist.grid(row=2, column=1)

lbl3 = Label(wrapper3, text="Product Quantity").grid(row=3, column=0, padx=5, pady=3)
ent3 = Entry(wrapper3, textvariable=pq, width="40", font=(20)).grid(
    row=3, column=1, padx=5, pady=3, ipady=5
)

lbl4 = Label(wrapper3, text="Product Price").grid(row=4, column=0, padx=5, pady=3)
ent4 = Entry(wrapper3, textvariable=pp, width="40", font=(20)).grid(
    row=4, column=1, padx=5, pady=3, ipady=5
)


total_btn = Button(
    wrapper3,
    text="Update Total",
    command=getTotal,
    bg="INDIANRED",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=2, column=3, padx=5, pady=3)
ent5 = Entry(
    wrapper3, textvariable=total, state="disabled", width="20", font=(20)
).grid(row=1, column=3, padx=5, pady=3, ipady=5)


sell_btn = Button(
    wrapper3,
    text="Selled",
    command=sellproduct,
    bg="forestgreen",
    height=2,
    width=10,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=2, column=2, padx=5, pady=3)


clear_btn = Button(
    wrapper3,
    text="Clear",
    command=clearfields,
    bg="firebrick",
    height=2,
    width=10,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=3, column=2, padx=5, pady=3)

up_btn = Button(
    wrapper3,
    text="Update",
    command=update_product,
    bg="INDIANRED",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=5, column=0, padx=5, pady=3)
add_btn = Button(
    wrapper3,
    text="Add",
    command=add_product,
    bg="green",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=5, column=1, padx=5, pady=3)
delete_btn = Button(
    wrapper3,
    text="Delete",
    command=delete_product,
    bg="crimson",
    height=2,
    width=20,
    fg="white",
    font=("Ariel", 10, "bold"),
).grid(row=5, column=2, padx=5, pady=3)


root.title("Harsh Stationery")
root.configure(bg="teal")
root.geometry("1000x600")
root.resizable(0, 0)
root.mainloop()

