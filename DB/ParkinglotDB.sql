USE [master]
GO
/****** Object:  Database [Parking_Lot]    Script Date: 6/3/2022 5:42:30 PM ******/
CREATE DATABASE [Parking_Lot]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'Parking_Lot', FILENAME = N'H:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Parking_Lot.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'Parking_Lot_log', FILENAME = N'H:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Parking_Lot_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Parking_Lot].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Parking_Lot] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Parking_Lot] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Parking_Lot] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Parking_Lot] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Parking_Lot] SET ARITHABORT OFF
GO
ALTER DATABASE [Parking_Lot] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Parking_Lot] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Parking_Lot] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Parking_Lot] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Parking_Lot] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Parking_Lot] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Parking_Lot] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Parking_Lot] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Parking_Lot] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Parking_Lot] SET  DISABLE_BROKER
GO
ALTER DATABASE [Parking_Lot] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Parking_Lot] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Parking_Lot] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Parking_Lot] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Parking_Lot] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Parking_Lot] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Parking_Lot] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Parking_Lot] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Parking_Lot] SET  MULTI_USER
GO
ALTER DATABASE [Parking_Lot] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Parking_Lot] SET DB_CHAINING OFF
GO
ALTER DATABASE [Parking_Lot] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [Parking_Lot] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [Parking_Lot] SET DELAYED_DURABILITY = DISABLED
GO
USE [Parking_Lot]
GO
/****** Object:  Table [dbo].[Parking]    Script Date: 6/3/2022 5:42:30 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subscriptions]    Script Date: 6/3/2022 5:42:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subscriptions](
	[SubscriptionsId] [int] IDENTITY(1,1) NOT NULL,
	[Duration] [nvarchar](100) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK__Subscrip__49137A25C9DEDD15] PRIMARY KEY CLUSTERED
(
	[SubscriptionsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/3/2022 5:42:30 PM ******/
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
	[Role] [int] NOT NULL,
	[ParkingId] [int] NOT NULL,
 CONSTRAINT [PK__User__1788CC4C70480280] PRIMARY KEY CLUSTERED
(
	[UserId] ASC
)WITH (PAD_INDEX = ON, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 1) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 6/3/2022 5:42:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[VehicleId] [int] IDENTITY(1,1) NOT NULL,
	[Category] [nvarchar](50) NOT NULL,
	[PlateNumber] [nvarchar](20) NOT NULL,
	[BrandName] [nvarchar](150) NOT NULL,
	[ModelName] [nvarchar](150) NOT NULL,
	[PrakingId] [int] NOT NULL,
	[date] [datetime] NOT NULL,
	[SubscriptionId] [int] NULL,
 CONSTRAINT [PK__Vehicle__476B54928FFBD441] PRIMARY KEY CLUSTERED
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleRegistration]    Script Date: 6/3/2022 5:42:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleRegistration](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[VehicleId] [int] NOT NULL,
	[DateTime] [datetime2](7) NOT NULL,
	[Event] [int] NOT NULL,
 CONSTRAINT [PK_VehicleRegistration] PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleSubscription]    Script Date: 6/3/2022 5:42:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleSubscription](
	[VehicleId] [int] IDENTITY(1,1) NOT NULL,
	[SubscriptionId] [int] NOT NULL,
 CONSTRAINT [PK_VehicleSubscription] PRIMARY KEY CLUSTERED
(
	[VehicleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Parking] ON
GO
INSERT [dbo].[Parking] ([Id], [Name], [AvailableParkingSpaces]) VALUES (1, N'Gurko', 200)
GO
INSERT [dbo].[Parking] ([Id], [Name], [AvailableParkingSpaces]) VALUES (2, N'VIPS', 442)
GO
SET IDENTITY_INSERT [dbo].[Parking] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON
GO
INSERT [dbo].[User] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Role], [ParkingId]) VALUES (5, N'admin', N'admin', N'admin@admin.admin', N'admin', 0x02000000312C438D3D7B07DB0427D420BB6487FDE9F9EB0FBB450C5211FA5EB63DA14522F2120F83A833387C455797B339E5D0A0, 1, 1)
GO
INSERT [dbo].[User] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Role], [ParkingId]) VALUES (6, N'rado', N'rimata', N'naradomeila@email.com', N'radko', 0x02000000FA7E23E6B65BA7E9CD0070D76625299C5F2D2029C5CE237E7FD8C4D79785117AD33A14F9EA515715CBE23908BFC1FD25, 1, 1)
GO
INSERT [dbo].[User] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Role], [ParkingId]) VALUES (7, N'pesho', N'pesho', N'pesho@email.com', N'pesho', 0x020000006DC5203D73FB3AF315DD25D04BE6742B120D0A0075F35D562E5AB2343C97F55DC64C432A916C39FB3264716CB2B81D4A, 1, 1)
GO
INSERT [dbo].[User] ([UserId], [FirstName], [LastName], [Email], [Username], [Password], [Role], [ParkingId]) VALUES (8, N'radost', N'radost', N'radost@email.com', N'radost', 0x02000000665ECA03A311FB785B283DE55D4F164827AEEF69532D16200EDDBBCD0B3EA086F5C7C9D9DD7B58A6E52CA501C0F3C9DB, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[VehicleRegistration] ADD  CONSTRAINT [DF_VehicleRegistration_DateTime]  DEFAULT (getdate()) FOR [DateTime]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User.ParkingId] FOREIGN KEY([ParkingId])
REFERENCES [dbo].[Parking] ([Id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User.ParkingId]
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
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [CK_User] CHECK  (([Email] like '%@%.%'))
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [CK_User]
GO
/****** Object:  StoredProcedure [dbo].[Procedurka]    Script Date: 6/3/2022 5:42:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Stoyan Ponchev>
-- Create date: <3/6/2022>
-- Description:	<Description>
-- =============================================
CREATE PROCEDURE [dbo].[Procedurka]
	-- Add the parameters for the stored procedure here

	@FirstName nvarchar(50),
	@LastName nvarchar(50),
	@Email varchar(100),
	@Username nvarchar(50),
	@Password nvarchar(50),
	@Role int,
	@ParkingId int
AS
BEGIN

	SET NOCOUNT ON;
	INSERT INTO [User](FirstName,LastName,
						Email,Username,[Password],[Role],ParkingId)
   VALUES (
	@FirstName,
	@LastName,
	@Email ,
	@Username,
	CONVERT(varbinary(MAX),EncryptByPassPhrase('pistol', @Password), 2),
	@Role ,
	@ParkingId )
END
GO
USE [master]
GO
ALTER DATABASE [Parking_Lot] SET  READ_WRITE
GO
