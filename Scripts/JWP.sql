CREATE TABLE [User] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Email] nvarchar NOT NULL,
  [Password] nvarchar NOT NULL,
  [FirstName] nvarchar,
  [LastName] nvarchar,
  [UserTypeID] int
)
GO

CREATE TABLE [UserType] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Type] nvarchar UNIQUE NOT NULL
)
GO

CREATE TABLE [UserHistory] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [UserID] int,
  [LogInAt] timestamp
)
GO

CREATE TABLE [Product] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Name] nvarchar NOT NULL,
  [Description] nvarchar,
  [SKU] nvarchar,
  [Price] decimal,
  [Quantity] int,
  [CategoryID] int
)
GO

CREATE TABLE [ProductCategory] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Name] nvarchar UNIQUE NOT NULL,
  [Description] nvarchar
)
GO

CREATE TABLE [OrderDetail] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [TotalPrice] decimal,
  [UserID] int,
  [PaymentID] int
)
GO

CREATE TABLE [OrderItem] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Quantity] int,
  [ProductID] int,
  [OrderID] int
)
GO

CREATE TABLE [PaymentDetail] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [CreatedAt] datetime,
  [PaymentMethodID] int,
  [PaymentStatusID] int
)
GO

CREATE TABLE [PaymentMethod] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Name] nvarchar UNIQUE NOT NULL
)
GO

CREATE TABLE [PaymentStatus] (
  [ID] int PRIMARY KEY IDENTITY(1, 1),
  [Name] nvarchar UNIQUE NOT NULL
)
GO

ALTER TABLE [User] ADD FOREIGN KEY ([UserTypeID]) REFERENCES [UserType] ([ID])
GO

ALTER TABLE [UserHistory] ADD FOREIGN KEY ([UserID]) REFERENCES [User] ([ID])
GO

ALTER TABLE [Product] ADD FOREIGN KEY ([CategoryID]) REFERENCES [ProductCategory] ([ID])
GO

ALTER TABLE [OrderDetail] ADD FOREIGN KEY ([UserID]) REFERENCES [User] ([ID])
GO

ALTER TABLE [OrderDetail] ADD FOREIGN KEY ([PaymentID]) REFERENCES [PaymentDetail] ([ID])
GO

ALTER TABLE [OrderItem] ADD FOREIGN KEY ([ProductID]) REFERENCES [Product] ([ID])
GO

ALTER TABLE [OrderItem] ADD FOREIGN KEY ([OrderID]) REFERENCES [OrderDetail] ([ID])
GO

ALTER TABLE [PaymentDetail] ADD FOREIGN KEY ([PaymentMethodID]) REFERENCES [PaymentMethod] ([ID])
GO

ALTER TABLE [PaymentDetail] ADD FOREIGN KEY ([PaymentStatusID]) REFERENCES [PaymentStatus] ([ID])
GO
