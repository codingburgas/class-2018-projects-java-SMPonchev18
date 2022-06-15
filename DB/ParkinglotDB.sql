
USE [Parkinglot]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[UserId] [int] NOT NULL,
	[AdminId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[AdminId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Parking]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Parking](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[AvailableParkingSpaces] [int] NOT NULL,
 CONSTRAINT [PK__Parking__3214EC07A644DF27] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SecurityGuard]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SecurityGuard](
	[UserId] [int] NOT NULL,
	[ParkingId] [int] NOT NULL,
	[GuardId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_SecurityGuard] PRIMARY KEY CLUSTERED 
(
	[GuardId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subscriptions]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subscriptions](
	[SubscriptionsId] [int] NOT NULL,
	[Duration] [nvarchar](100) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK__Subscrip__49137A25C9DEDD15] PRIMARY KEY CLUSTERED 
(
	[SubscriptionsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [varbinary](max) NOT NULL,
 CONSTRAINT [PK__User__1788CC4C70480280] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = ON, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 1, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[VehicleId] [int] IDENTITY(1,1) NOT NULL,
	[Category] [int] NOT NULL,
	[PlateNumber] [nvarchar](20) NOT NULL,
	[BrandName] [nvarchar](150) NOT NULL,
	[ModelName] [nvarchar](150) NOT NULL,
	[PrakingId] [int] NOT NULL,
 CONSTRAINT [PK__Vehicle__476B54928FFBD441] PRIMARY KEY CLUSTERED 
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_Vehicle] UNIQUE NONCLUSTERED 
(
	[PlateNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleRegistration]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleRegistration](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[VehicleId] [int] NOT NULL,
	[DateTime] [datetime2](7) NULL,
 CONSTRAINT [PK_VehicleRegistration] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleSubscription]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleSubscription](
	[VehicleId] [int] NOT NULL,
	[SubscriptionId] [int] NOT NULL,
 CONSTRAINT [PK_VehicleSubscription] PRIMARY KEY CLUSTERED 
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[VehicleRegistration] ADD  CONSTRAINT [DF_VehicleRegistration_DateTime]  DEFAULT (getutcdate()) FOR [DateTime]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [FK_Admin_User] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([UserId])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [FK_Admin_User]
GO
ALTER TABLE [dbo].[SecurityGuard]  WITH CHECK ADD  CONSTRAINT [FK_SecurityGuard_Parking] FOREIGN KEY([ParkingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[SecurityGuard] CHECK CONSTRAINT [FK_SecurityGuard_Parking]
GO
ALTER TABLE [dbo].[SecurityGuard]  WITH CHECK ADD  CONSTRAINT [FK_SecurityGuard_User] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([UserId])
GO
ALTER TABLE [dbo].[SecurityGuard] CHECK CONSTRAINT [FK_SecurityGuard_User]
GO
ALTER TABLE [dbo].[Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_Vehicle.PrakingId] FOREIGN KEY([PrakingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[Vehicle] CHECK CONSTRAINT [FK_Vehicle.PrakingId]
GO
ALTER TABLE [dbo].[VehicleRegistration]  WITH CHECK ADD  CONSTRAINT [FK_VehicleRegistration_Vehicle] FOREIGN KEY([VehicleId])
REFERENCES [dbo].[Vehicle] ([VehicleId])
GO
ALTER TABLE [dbo].[VehicleRegistration] CHECK CONSTRAINT [FK_VehicleRegistration_Vehicle]
GO
ALTER TABLE [dbo].[VehicleSubscription]  WITH CHECK ADD  CONSTRAINT [FK_VehicleSubscription_Subscriptions] FOREIGN KEY([SubscriptionId])
REFERENCES [dbo].[Subscriptions] ([SubscriptionsId])
GO
ALTER TABLE [dbo].[VehicleSubscription] CHECK CONSTRAINT [FK_VehicleSubscription_Subscriptions]
GO
ALTER TABLE [dbo].[VehicleSubscription]  WITH CHECK ADD  CONSTRAINT [FK_VehicleSubscription_Vehicle] FOREIGN KEY([VehicleId])
REFERENCES [dbo].[Vehicle] ([VehicleId])
GO
ALTER TABLE [dbo].[VehicleSubscription] CHECK CONSTRAINT [FK_VehicleSubscription_Vehicle]
GO
/****** Object:  StoredProcedure [dbo].[insertAdmin]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertAdmin]
		@firstName nvarchar(50),
	@lastName nvarchar(50),
	@email varchar(100),
	@username nvarchar(50),
	@password varchar(50)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    EXEC insertUser @FirstName=@firstName , @LastName=@lastName,
	@Email=@email, @Username=@username,@Password=@password;
	

	INSERT INTO [Admin](UserId)
	SELECT UserId FROM [User] WHERE FirstName=@firstName AND LastName=@lastName AND
	Email=@email AND Username=@username
END
GO
/****** Object:  StoredProcedure [dbo].[insertUser]    Script Date: 6/15/2022 1:38:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertUser]
	@FirstName nvarchar(50),
	@LastName nvarchar(50),
	@Email varchar(100),
	@Username nvarchar(50),
	@Password varchar(50)

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

   INSERT INTO [User](FirstName,LastName,Email,Username,Password)
   VALUES(@FirstName,@LastName,@Email,@Username,
   CONVERT(varbinary(max),EncryptByPassPhrase('pistol',@Password)   ,2))
END
GO
USE [master]
GO
ALTER DATABASE [Parkinglot] SET  READ_WRITE 
GO
