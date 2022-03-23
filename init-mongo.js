db.CreateUser(
    {
        user: "vaudkeith",
        pwd: "vaud123",
        roles: [
            {
                role: "readWrite",
                db: "todos-db"
            }
        ]
    }
)