CREATE DATABASE JWP
GO

USE JWP
GO

CREATE TABLE [User] (
  [ID]          int PRIMARY KEY IDENTITY(1, 1),
  [Email]       nvarchar(50) NOT NULL,
  [Password]    nvarchar(50) NOT NULL,
  [FirstName]   nvarchar(50),
  [LastName]    nvarchar(50),
  [UserTypeID]  int
)
GO

CREATE TABLE [UserType] (
  [ID]    int PRIMARY KEY IDENTITY(1, 1),
  [Type]  nvarchar(50) UNIQUE NOT NULL
)
GO

CREATE TABLE [UserHistory] (
  [ID]      int PRIMARY KEY IDENTITY(1, 1),
  [UserID]  int,
  [LogInAt] timestamp
)
GO

CREATE TABLE [Product] (
  [ID]          int PRIMARY KEY IDENTITY(1, 1),
  [Name]        nvarchar(50) NOT NULL,
  [Description] nvarchar(50),
  [SKU]         nvarchar(50),
  [Price]       decimal,
  [Quantity]    int,
  [CategoryID]  int
)
GO

CREATE TABLE [ProductCategory] (
  [ID]          int PRIMARY KEY IDENTITY(1, 1),
  [Name]        nvarchar(50) UNIQUE NOT NULL,
  [Description] nvarchar(50)
)
GO

CREATE TABLE [OrderDetail] (
  [ID]          int PRIMARY KEY IDENTITY(1, 1),
  [TotalPrice]  decimal,
  [UserID]      int,
  [PaymentID]   int
)
GO

CREATE TABLE [OrderItem] (
  [ID]        int PRIMARY KEY IDENTITY(1, 1),
  [Quantity]  int,
  [ProductID] int,
  [OrderID]   int
)
GO

CREATE TABLE [PaymentDetail] (
  [ID]              int PRIMARY KEY IDENTITY(1, 1),
  [CreatedAt]       datetime,
  [PaymentMethodID] int,
  [PaymentStatusID] int
)
GO

CREATE TABLE [PaymentMethod] (
  [ID]    int PRIMARY KEY IDENTITY(1, 1),
  [Name]  nvarchar(50) UNIQUE NOT NULL
)
GO

CREATE TABLE [PaymentStatus] (
  [ID]    int PRIMARY KEY IDENTITY(1, 1),
  [Name]  nvarchar(50) UNIQUE NOT NULL
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

-- Insert rows into table 'dbo.UserType'
INSERT INTO dbo.UserType
    ([Type])
VALUES
    ('Admin'),
    ('User')
GO
